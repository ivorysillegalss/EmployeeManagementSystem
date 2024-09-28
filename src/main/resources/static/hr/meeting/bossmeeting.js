document.addEventListener('DOMContentLoaded', function() {
    // 假数据
    const mockData = {
        name: '秋季技术研讨会',
        location: '广州科技馆',
        hrId: 103
    };

    // 初始化表单数据为假数据
    document.getElementById('name').value = mockData.name;
    document.getElementById('location').value = mockData.location;
    document.getElementById('hr_id').value = mockData.hrId;

    // 获取表单元素
    const meetingForm = document.getElementById('meetingForm');

    // 监听表单提交事件
    meetingForm.addEventListener('submit', function(event) {
        event.preventDefault(); // 防止页面刷新

        // 获取表单数据
        const name = document.getElementById('name').value;
        const location = document.getElementById('location').value;
        const hrId = document.getElementById('hr_id').value;

        // 创建会议数据对象
        const eventDTO = {
            name: name,
            location: location,
            hrId: hrId
        };

        // 发送会议数据到后端
        axios.post('http://localhost:3000/hr/meeting', eventDTO)
            .then(function(response) {
                if (response.data.code === "0") {
                    alert('会议发起成功！');
                    // 会议发起成功后的操作，如页面跳转或清空表单
                    meetingForm.reset(); // 清空表单
                } else {
                    alert('发起会议失败: ' + response.data.message);
                }
            })
            .catch(function(error) {
                console.error('请求发生错误: ', error);
                alert('请求失败，请稍后再试。');
            });
    });
});

document.getElementById('exit').addEventListener('click', function (event) {
    window.location.href = '../index-hr.html'
})

