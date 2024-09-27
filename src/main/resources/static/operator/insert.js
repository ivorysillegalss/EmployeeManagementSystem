document.getElementById('insertForm').addEventListener('submit', function (event) {
    event.preventDefault(); // 阻止表单默认提交行为

    // var operatorId = document.getElementById('operatorId').value;
    var operatorId = 1;
    // var userId = document.getElementById('userId').value;
    var operatorRole = document.getElementById('operatorRole').value;
    // var createAt = document.getElementById('createAt').value;
    // var updateAt = document.getElementById('updateAt').value;

    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var role = document.getElementById('role').value;
    var email = document.getElementById('email').value;
    var phone = document.getElementById('phone').value;
    // var userCreateTime = document.getElementById('userCreateTime').value;
    // var userUpdateTime = document.getElementById('userUpdateTime').value;

    var operatorDTO = {
        operator: {
            // operatorId: operatorId,
            // userId: userId,
            operatorRole: operatorRole,
            // createAt: createAt,
            // updateAt: updateAt
        },
        user: {
            // userId: userId,
            username: username,
            password: password,
            role: role,
            email: email,
            phone: phone,
            // createTime: userCreateTime,
            // updateTime: userUpdateTime
        }
    };

    axios.post('http://localhost:3000/operator/insert/' + operatorId, operatorDTO)
        .then(function (response) {
            console.log(response)
            if (response.data.code == "0") {

            }
            // console.log(response.data)
            // document.getElementById('result').innerText = response.data.message;
            document.getElementById('result').innerText = '操作员添加成功';

        })
        .catch(function (error) {
            console.error('请求失败:', error);
            document.getElementById('result').innerText = '请求失败，请稍后再试。';
        });
});

// const bt=document.querySelector('.back');
// console.log(bt)
// bt.addEventListener('click',function(){
//     backIndex();
// })

function backIndex() {
    window.location.href = '/index-operator'
}