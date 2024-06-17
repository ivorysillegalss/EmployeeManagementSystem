document.getElementById('homeButton').addEventListener('click',function(event){
    window.location.href = '../index-operator.html'
})




document.getElementById('modifyForm').addEventListener('submit', function(event) {
    event.preventDefault(); // 阻止表单默认提交行为

    var operatorId = document.getElementById('operatorId').value;
    var userId = document.getElementById('userId').value;
    var newRole = document.getElementById('newRole').value;

    var operatorDTO = {
        newRole: newRole
    };

    axios.post(`http://localhost:3000/operator/modify/${operatorId}/user/${userId}`, operatorDTO)
        .then(function(response) {
            if (response.data.success) {
                document.getElementById('result').innerText = '权限修改成功：';
                document.getElementById('modifyForm').reset();
            } else {
                document.getElementById('result').innerText = '修改失败：' + response.data.code;
            }
        })
        .catch(function(error) {
            console.error('请求失败:', error);
            document.getElementById('result').innerText = '请求失败，请稍后再试。';
        });
});
