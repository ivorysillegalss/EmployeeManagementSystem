document.addEventListener('DOMContentLoaded', function() {
    // 假数据
    const mockData = [
        { eventId: 1, name: '春季招聘会', time: '2024-05-10 14:00',status:"成功", location: '北京国际会议中心', hrId: 101 },
        { eventId: 2, name: '夏季产品发布会', time: '2024-06-15 09:00', status:"成功",location: '上海展览中心', hrId: 102 },
        { eventId: 3, name: '秋季技术研讨会', time: '2024-09-20 10:00',status:"成功", location: '广州科技馆', hrId: 103 },
        { eventId: 4, name: '冬季慈善晚宴', time: '2024-12-05 18:00', status:"成功",location: '深圳湾体育馆', hrId: 104 },
        { eventId: 5, name: '春季创新论坛', time: '2025-03-01 13:00', status:"成功",location: '杭州国际会议中心', hrId: 105 },
        { eventId: 6, name: '夏季艺术展览', time: '2025-07-10 15:00', status:"成功",location: '成都艺术中心', hrId: 106 }
    ];

    // 使用 axios 获取会议列表
    axios.get('http://localhost:3000/user/meeting')
        .then(function(response) {
            if (response.data.code === "0") {
                console.log('会议列表获取成功');

                // 将后端返回的数据与假数据合并
                const meetings = [...mockData, ...response.data.data];

                // 获取表格的 tbody 元素
                const tableBody = document.getElementById('data-table').getElementsByTagName('tbody')[0];

                // 清空表格内容（如果需要）
                tableBody.innerHTML = '';

                // 遍历合并后的会议列表并插入到表格中
                meetings.forEach(meeting => {
                    const row = tableBody.insertRow();
                    row.insertCell(0).textContent = meeting.eventId;  // 活动ID
                    row.insertCell(1).textContent = meeting.name;       // 名称
                    row.insertCell(2).textContent = meeting.time;       // 时间
                    row.insertCell(3).textContent = "成功"
                    row.insertCell(4).textContent = meeting.location;   // 地点
                    row.insertCell(5).textContent = meeting.hrId;      // HR ID

                    // 添加操作列
                    const actionCell = row.insertCell(6);

                    // 同意按钮
                    const agreeButton = document.createElement('button');
                    agreeButton.textContent = '同意';
                    agreeButton.className = 'agree';
                    agreeButton.onclick = function() { handleResponse(meeting.eventId, true); };
                    actionCell.appendChild(agreeButton);

                    // 不同意按钮
                    const disagreeButton = document.createElement('button');
                    disagreeButton.textContent = '不同意';
                    disagreeButton.className = 'disagree';
                    disagreeButton.onclick = function() { handleResponse(meeting.eventId, false); };
                    actionCell.appendChild(disagreeButton);
                });
            } else {
                alert('获取会议列表失败: ' + response.data.message);
            }
        })
        .catch(function(error) {
            console.error('请求发生错误: ', error);
            alert('请求发生错误，请稍后重试。');
        });
});

// 处理请假请求的函数
function handleResponse(eventId, agree) {
    const opinion = agree ? 1 : -1; // 同意传 1，拒绝传 -1
    const empId = localStorage.getItem('userId'); // 假设 eventId 就是 empId，具体根据实际业务逻辑调整
    console.log(empId)

    // 发送同意或拒绝请求到后端
    axios.post(`http://localhost:3000/hr/vacation/${empId}/${opinion}`)
        .then(function(response) {
            if (response.data.code === "0") {
                if (agree) {
                    alert('请假请求已同意，活动ID: ' + empId);
                    console.log('请假请求已同意，活动ID:', empId);
                } else {
                    alert('请假请求已拒绝，活动ID: ' + empId);
                    console.log('请假请求已拒绝，活动ID:', empId);
                }
            } else {
                alert('操作失败: ' + response.data.message);
            }
        })
        .catch(function(error) {
            console.error('请求发生错误: ', error);
            alert('请求发生错误，请稍后重试。');
        });
}
