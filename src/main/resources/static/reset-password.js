document.getElementById('resetPasswordForm').addEventListener('submit', function (event) {
    event.preventDefault(); // 阻止表单默认提交行为

    var username = document.getElementById('username').value;
    var beforePassword = document.getElementById('beforePassword').value;
    var newPassword = document.getElementById('newPassword').value;

    var userDTO = {
        username: username,
        beforePassword: beforePassword,
        afterPassword: newPassword
    };

    console.log(userDTO);

    axios.post('http://localhost:3000/user/password/reset', userDTO)
        .then(function (response) {
            var resultDiv = document.getElementById('result');
            resultDiv.className = ''; // 清空之前的类
            if (response.data.code == "0") {
                resultDiv.innerText = '密码重置成功';
                resultDiv.classList.add('success');
                document.getElementById('resetPasswordForm').reset();
            } else {
                resultDiv.innerText = '密码重置失败：' + response.data.message;
                resultDiv.classList.add('error');
            }
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            var resultDiv = document.getElementById('result');
            resultDiv.className = ''; // 清空之前的类
            resultDiv.innerText = '请求失败，请稍后再试。';
            resultDiv.classList.add('error');
        });
});
