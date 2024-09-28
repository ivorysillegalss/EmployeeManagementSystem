document.addEventListener('DOMContentLoaded', function() {
    const tableBody = document.getElementById('table-body');

    // 使用 axios 获取从后端接收的请假数据
    axios.get('http://localhost:3000/hr/vacation')
        .then(function (response) {
            if (response.data.code === "0") {
                // 渲染表格数据
                const vacationData = response.data.data;
                console.log(vacationData)
                renderTable(vacationData);
                handleActions();
            } else {
                alert('获取请假信息失败: ' + response.data.message);
            }
        })
        .catch(function (error) {
            console.error('请求发生错误: ', error);
            alert('获取请假信息时发生错误，请稍后再试。');
        });

    // 渲染表格
    function renderTable(data) {
        data.forEach(item => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${item.vacationId}</td>
                <td>${item.userId}</td>
                <td>${item.hrOpinion}</td>
                <td>${item.bossOpinion}</td>
                <td>
                    <button class="approve">批准</button>
                    <button class="reject">不批准</button>
                </td>
            `;
            tableBody.appendChild(row);
        });
    }

    // 处理按钮点击事件
    function handleActions() {
        document.querySelectorAll('.approve').forEach(button => {
            button.addEventListener('click', function() {
                const row = this.closest('tr');
                const empId = row.cells[1].innerText;

                // 调用后端的批准接口
                axios.post(`http://localhost:3000/hr/vacation/${empId}/1`)
                    .then(function (response) {
                        if (response.data.code === "0") {
                            alert('请假申请已批准');
                            row.cells[2].innerText = 'Approved'; // 更新页面显示
                        } else {
                            alert('操作失败: ' + response.data.message);
                        }
                    })
                    .catch(function (error) {
                        console.error('请求失败:', error);
                        alert('批准请求时发生错误，请稍后再试。');
                    });
            });
        });

        document.querySelectorAll('.reject').forEach(button => {
            button.addEventListener('click', function() {
                const row = this.closest('tr');
                const vacationId = row.cells[0].innerText;

                // 调用后端的拒绝接口
                axios.post(`http://localhost:3000/hr/vacation/${vacationId}/-1`)
                    .then(function (response) {
                        if (response.data.code === "0") {
                            alert('请假申请已拒绝');
                            row.cells[2].innerText = 'Rejected'; // 更新页面显示
                        } else {
                            alert('操作失败: ' + response.data.message);
                        }
                    })
                    .catch(function (error) {
                        console.error('请求失败:', error);
                        alert('拒绝请求时发生错误，请稍后再试。');
                    });
            });
        });
    }
});
