document.addEventListener('DOMContentLoaded', function () {
    axios.get('http://localhost:3000/user/meeting')
        .then(function (response) {
            console.log(response.data);

            // 判断返回的状态码
            if (response.data.code === "0") {
                console.log('会议列表获取成功');
                const meetings = response.data.data;

                // 获取表格的 tbody 元素
                const tableBody = document.getElementById('data-table').getElementsByTagName('tbody')[0];
                let a;
                if (meetings.status === 1) {
                    a = "成功"
                }
                // 遍历会议列表并插入到表格中
                meetings.forEach(meeting => {
                    const row = tableBody.insertRow();
                    row.insertCell(0).textContent = meeting.eventId;  // 活动ID
                    row.insertCell(1).textContent = meeting.name;       // 名称
                    row.insertCell(2).textContent = meeting.time;       // 时间
                    row.insertCell(3).textContent = "成功"       // 状态 (你可以根据需要更改)
                    row.insertCell(4).textContent = meeting.location;   // 地点
                    row.insertCell(5).textContent = meeting.hrId;      // HR ID

                    // 添加 "请假" 按钮
                    const actionCell = row.insertCell(6);
                    const leaveButton = document.createElement('button');
                    leaveButton.textContent = '请假';
                    let item = localStorage.getItem('userId');
                    leaveButton.onclick = function () {
                        handleLeaveRequest(item);
                    };
                    actionCell.appendChild(leaveButton);
                });
            } else {
                alert('获取会议列表失败: ' + response.data.message);
            }
        })
        .catch(function (error) {
            console.error('请求发生错误: ', error);
            alert('请求发生错误，请稍后重试');
        });
});

// 处理请假请求的函数
function handleLeaveRequest(empId) {
    if (confirm('确定要请假吗？')) {
        // 发送请假请求到后端
        axios.post(`http://localhost:3000/user/emp/vacation/${empId}`)
            .then(function (response) {
                console.log(response.data);

                if (response.data.code === "0") {
                    alert('请假申请成功。');
                    console.log('请假请求成功，员工ID:', empId);
                } else {
                    alert('请假申请失败: ' + response.data.message);
                }
            })
            .catch(function (error) {
                console.error('请求发生错误: ', error);
                alert('请假请求失败，请稍后重试。');
            });
    } else {
        alert('请假请求已取消。');
    }
}
