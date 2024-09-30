// 这里的hrId是没用的 指前端没用后端也没用 随便定义一个就好
var id = 1;

// 展示雇员的基本信息
document.getElementById('showEmpInfo').addEventListener('click', function () {
    axios.get('http://localhost:3000/hr')
        .then(function (response) {
            if (response.data.code === "0") {
                var empInfo = response.data.data;
                var content = '<h3>雇员信息</h3>'
                empInfo.forEach(function (record) {
                    content += `
                        <li>雇员ID：${record.empId}</li>
                        <li>姓名：${record.name}</li>
                        <li>雇员时间：${new Date(record.empTime * 1000).toLocaleString()}</li>
                        <li>性别：${record.gender ? '男' : '女'}</li>
                        <li>地址：${record.address}</li>
                        <li>电话：${record.phone}</li>
                        <li>电子邮件：${record.email}</li>
                        <li>部门ID：${record.departmentId}</li>
                        <li>部门名称：${record.departmentName}</li>
                        <li>职位ID：${record.positionId}</li>
                        <li>职称ID：${record.titleId}</li>
                        <li>状态：${record.status}</li>
                        <li>用户ID：${record.userId}</li>
                        <hr>`;
                    content += '\n';
                });
                showModal(content)
                // document.getElementById('empInfoResult').innerText = JSON.stringify(response.data.data);
            } else {
                document.getElementById('empInfoResult').innerText = "请求异常";
            }
        })
        .catch(function (error) {
            document.getElementById('empInfoResult').innerText = '请求失败：' + error;
        });
});


// 培训相关
document.getElementById('doTraining').addEventListener('click', function () {
    var id = document.getElementById('trainEmpId').value;
    var training = {
        empId: id,
        trainingName: document.getElementById('trainingName').value,
        date: document.getElementById('trainingDate').value
    };
    axios.post(`http://localhost:3000/hr/train/${id}`, training)
        .then(function (response) {

            console.log(response)

            if (response.data.code == "0") {
                document.getElementById('trainResult').innerText = "成功";
            }
        })
        .catch(function (error) {
            document.getElementById('trainResult').innerText = '请求失败：' + error;
        });
});


// 奖金
document.getElementById('doBonus').addEventListener('click', function () {
    var id = document.getElementById('bonusEmpId').value;
    var bonus = {
        empId: id,
        amount: document.getElementById('bonusAmount').value
    };
    axios.post(`http://localhost:3000/hr/bonus/${id}`, bonus)
        .then(function (response) {
            if (response.data.code == "0") {
                document.getElementById('bonusResult').innerText = '增加成功';
            }
            // document.getElementById('bonusResult').innerText = JSON.stringify(response.data);
        })
        .catch(function (error) {
            document.getElementById('bonusResult').innerText = '请求失败：' + error;
        });
});


// 扣钱
document.getElementById('doDeductions').addEventListener('click', function () {
    var id = document.getElementById('deductEmpId').value;
    var deduction = {
        empId: id,
        amount: document.getElementById('deductAmount').value
    };
    axios.post(`http://localhost:3000/hr/deductions/${id}`, deduction)
        .then(function (response) {
            if (response.data.code == "0") {
                document.getElementById('deductResult').innerText = '扣钱成功';
            }
            // document.getElementById('deductResult').innerText = JSON.stringify(response.data);
        })
        .catch(function (error) {
            document.getElementById('deductResult').innerText = '请求失败：' + error;
        });
});


document.getElementById('insertEmployee').addEventListener('click', function (event) {
    window.location.href = './insert/insert-emp.html';
});


// fire
document.getElementById('fireEmployee').addEventListener('click', function () {
    // var hrId = document.getElementById('fireEmpHrId').value;
    var hrId = 1;
    var empName = document.getElementById('fireEmpName').value;

    var humanResourceDTO = {
        name: empName
    }

    axios.post(`http://localhost:3000/hr/fire/${hrId}`, humanResourceDTO)
        .then(function (response) {
            if (response.data.code === "0") {
                document.getElementById('fireResult').innerText = '裁员成功';
            }
        })

        .catch(function (error) {
            document.getElementById('fireResult').innerText = '请求失败：' + error;
        });
});


document.getElementById('modifyEmployee').addEventListener('click', function () {
    // var hrId = document.getElementById('modifyEmpHrId').value;
    var hrId = 1;
    var modification = {
        modifiedEmpId: document.getElementById('modifyEmpId').value,
        newDepartment: document.getElementById('newDepartment').value
    };
    axios.post(`http://localhost:3000/hr/modify/${hrId}`, modification)
        .then(function (response) {
            if (response.data.code == "0") {
                document.getElementById('modifyResult').innerText = '请求成功';
            }
        })
        .catch(function (error) {
            document.getElementById('modifyResult').innerText = '请求失败：' + error;
        });
});


// 显示悬浮窗
function showModal(content) {
    var modal = document.getElementById('modal');
    var modalBody = document.getElementById('modalBody');
    modalBody.innerHTML = content;
    modal.style.display = 'block';
}


// 隐藏悬浮窗
function hideModal() {
    var modal = document.getElementById('modal');
    modal.style.display = 'none';
}

// 悬浮窗关闭按钮点击事件
document.querySelector('.close').addEventListener('click', hideModal);

// 点击其他地方隐藏悬浮窗
window.addEventListener('click', function (event) {
    var modal = document.getElementById('modal');
    if (event.target === modal) {
        hideModal();
    }
});


document.getElementById('exit').addEventListener('click', function (event) {
    window.location.href = '../login.html'
})


document.getElementById('applyMeeting').addEventListener('click', function () {
    window.location.href = './meeting/hrmeeting.html'
})

document.getElementById("permitVacation").addEventListener('click', function () {
    window.location.href = './vacation/hrAuditvacation.html'
})

document.getElementById("permitPurchase").addEventListener('click', function () {
    window.location.href = './purchase/columns.html'
})

document.getElementById("positionChange").addEventListener('click', function () {
    window.location.href = './positionchange/position_change.html'
})