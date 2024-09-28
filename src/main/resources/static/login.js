document.getElementById('loginForm').addEventListener('submit', function (event) {

    event.preventDefault(); // 阻止表单默认提交行为

    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    var userDTO = {
        username: username,
        password: password
    };


    // console.log(response.data)

    axios.post('http://localhost:3000/user/login', userDTO)
        .then(function (response) {

            console.log(response.data)
            // 根据响应进行相应的处理
            if (response.data.code === "0") {
                console.log('登录成功');
                // 重定向或其他操作
                let role = response.data.data.role;
                localStorage.setItem('userId', response.data.data.userId)
                console.log(role)
                if (role === "4") {
                    window.location.href = './boss/index.html'
                } else if (role === "1") {
                    window.location.href = './operator/index-operator.html'
                } else if (role === "2") {
                    window.location.href = './hr/index-hr.html'
                } else {
                    window.location.href = './user/info.html';
                }

            } else {
                alert('登录失败: ' + response.data.message);
            }
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            alert('登录过程中出现错误，请稍后再试。');
        });
});

document.getElementById("resetPassword").addEventListener('click', function (event) {
    window.location.href = './reset-password.html';
})

document.getElementById("register").addEventListener('click', function (event) {
    window.location.href = './register.html'
})

document.getElementById("showVacation").addEventListener('click', function (event) {
    window.location.href = './boss/meeting/bossevent.html'
})

document.getElementById("applyMeeting").addEventListener('click', function (event) {
    window.location.href = './hr/meeting/hrmeeting.html'
})