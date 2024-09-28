document.addEventListener('DOMContentLoaded', function() {
    const data = [
        { event_id: 1, name: '春季招聘会', time: '2024-05-10 14:00', status: '已完成', location: '北京国际会议中心', hr_id: 101 },
        { event_id: 2, name: '夏季产品发布会', time: '2024-06-15 09:00', status: '进行中', location: '上海展览中心', hr_id: 102 },
        { event_id: 3, name: '秋季技术研讨会', time: '2024-09-20 10:00', status: '计划中', location: '广州科技馆', hr_id: 103 },
        { event_id: 4, name: '冬季慈善晚宴', time: '2024-12-05 18:00', status: '已完成', location: '深圳湾体育馆', hr_id: 104 },
        { event_id: 5, name: '春季创新论坛', time: '2025-03-01 13:00', status: '计划中', location: '杭州国际会议中心', hr_id: 105 },
        { event_id: 6, name: '夏季艺术展览', time: '2025-07-10 15:00', status: '进行中', location: '成都艺术中心', hr_id: 106 }
    ];

    const tableBody = document.getElementById('data-table').getElementsByTagName('tbody')[0];

    data.forEach((item) => {
        const row = tableBody.insertRow();
        row.insertCell(0).textContent = item.event_id;
        row.insertCell(1).textContent = item.name;
        row.insertCell(2).textContent = item.time;
        row.insertCell(3).textContent = item.status;
        row.insertCell(4).textContent = item.location;
        row.insertCell(5).textContent = item.hr_id;
    });
});