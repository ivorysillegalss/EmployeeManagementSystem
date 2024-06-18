document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('newEmployeeForm').addEventListener('submit', function(event) {
        event.preventDefault(); // 阻止表单默认提交行为

        const newEmployeeData = {
            user: {
                username: document.getElementById('username').value,
                password: document.getElementById('password').value,
                role: document.getElementById('role').value,
                email: document.getElementById('userEmail').value,
                phone: document.getElementById('userPhone').value,
                createTime: Math.floor(Date.now() / 1000), // 当前时间作为创建时间
                updateTime: Math.floor(Date.now() / 1000)  // 当前时间作为更新时间
            },
            employee: {
                name: document.getElementById('name').value,
                empTime: new Date(document.getElementById('empTime').value).getTime() / 1000,
                gender: document.getElementById('gender').value === 'true',
                address: document.getElementById('address').value,
                phone: document.getElementById('empPhone').value,
                email: document.getElementById('empEmail').value,
                departmentId: parseInt(document.getElementById('departmentId').value, 10),
                // departmentName: document.getElementById('departmentName').value,
                positionId: parseInt(document.getElementById('positionId').value, 10),
                titleId: parseInt(document.getElementById('titleId').value, 10),
                status: document.getElementById('status').value,
                userId: 0 // 将在后端生成并分配
            }
        };

        var hrId = 1;
        axios.post(`http://localhost:3000/hr/insert/${hrId}`, newEmployeeData)
            .then(function(response) {

                console.log(response.data)

                if(response.data.code == "0"){
                    document.getElementById('resultMessage').innerText = '员工信息添加成功';
                    document.getElementById('newEmployeeForm').reset();
                }

            })
            .catch(function(error) {
                document.getElementById('resultMessage').innerText = '请求失败：' + error;
            });
    });
});


document.getElementById('exit').addEventListener('click',function(event){
    window.location.href = '../index-hr.html'
})