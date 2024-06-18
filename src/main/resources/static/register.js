document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('registerForm').addEventListener('submit', function (event) {
        event.preventDefault(); // 阻止表单默认提交行为

        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirmPassword').value;
        const email = document.getElementById('email').value;
        const phone = document.getElementById('phone').value;

        if (password !== confirmPassword) {
            document.getElementById('resultMessage').innerText = '密码和确认密码不匹配';
            return;
        }

        const userDTO = {
            user: {
                username: username,
                password: password,
                email: email,
                phone: phone
            }
        };

        axios.post('http://localhost:3000/user/register', userDTO)
            .then(function (response) {
                console.log(response)

                if (response.data.code == "0") {
                    alert('注册成功!')
                    window.location.href = './login.html';
                }
            })
            .catch(function (error) {
                document.getElementById('resultMessage').innerText = '请求失败：' + error;
            });
    });
});
