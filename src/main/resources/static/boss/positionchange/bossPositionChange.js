document.addEventListener('DOMContentLoaded', function () {
    // 从后端获取人事变动列表
    axios.get('http://localhost:3000/boss/position/change')
        .then(function (response) {
            if (response.data.code === "0") {
                renderTable(response.data.data);
            } else {
                alert('获取人事变动列表失败: ' + response.data.message);
            }
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            alert('获取人事变动列表时发生错误，请稍后再试。');
        });

    // 渲染表格
    function renderTable(data) {
        const tableBody = document.getElementById('positionChangeTable').getElementsByTagName('tbody')[0];
        tableBody.innerHTML = ''; // 清空现有表格数据

        data.forEach(function (item) {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${item.positionChangeId}</td>
                <td>${item.userId}</td>
                <td>${item.hrId}</td>
                <td>${item.formalPosition}</td>
                <td>${item.afterPosition}</td>
                <td>${item.status ? '已审批' : '待审批'}</td>
                <td>
                    ${item.status ? '' : `
                        <button class="approve" onclick="approveChange(${item.positionChangeId})">批准</button>
                        <button class="reject" onclick="rejectChange(${item.positionChangeId})">拒绝</button>
                    `}
                </td>
            `;
            tableBody.appendChild(row);
        });
    }

    // 批准操作
    window.approveChange = function (positionChangeId) {
        if (confirm(`确定要批准变动ID为 ${positionChangeId} 的申请吗？`)) {
            axios.post(`http://localhost:3000/boss/position/change/${positionChangeId}/1`)
                .then(function (response) {
                    if (response.data.code === "0") {
                        alert('已批准');
                        // 重新加载表格数据
                        location.reload();
                    } else {
                        alert('操作失败: ' + response.data.message);
                    }
                })
                .catch(function (error) {
                    console.error('请求失败:', error);
                    alert('批准操作时发生错误，请稍后再试。');
                });
        }
    };

    // 拒绝操作
    window.rejectChange = function (positionChangeId) {
        if (confirm(`确定要拒绝变动ID为 ${positionChangeId} 的申请吗？`)) {
            axios.post(`http://localhost:3000/boss/position/change/${positionChangeId}/-1`)
                .then(function (response) {
                    if (response.data.code === "0") {
                        alert('已拒绝');
                        // 重新加载表格数据
                        location.reload();
                    } else {
                        alert('操作失败: ' + response.data.message);
                    }
                })
                .catch(function (error) {
                    console.error('请求失败:', error);
                    alert('拒绝操作时发生错误，请稍后再试。');
                });
        }
    };
});
