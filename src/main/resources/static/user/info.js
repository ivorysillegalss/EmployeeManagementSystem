var userId = localStorage.getItem('userId'); // 用户ID从登录信息中获取

document.addEventListener('DOMContentLoaded', function () {
    // 获取用户ID，可以从登录时保存的session或token中获取

    // 调用接口获取用户信息
    axios.get(`http://localhost:3000/user/info/${userId}`)
        .then(function (response) {
            console.log(response.data)
            if (response.data.code == "0") {
                var user = response.data.data;
                displayUserInfo(user);
            } else {
                document.getElementById('userInfo').innerText = '无法获取用户信息：' + response.data.message;
            }
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            document.getElementById('userInfo').innerText = '请求失败，请稍后再试。';
        });

    // 显示用户信息
    function displayUserInfo(user) {
        var userInfoDiv = document.getElementById('userInfo');
        userInfoDiv.innerHTML = `
            <div><label>用户名：</label><span>${user.username}</span></div>
            <div><label>角色：</label><span>${user.role}</span></div>
            <div><label>电子邮件：</label><span>${user.email}</span></div>
            <div><label>电话：</label><span>${user.phone}</span></div>
            <div><label>创建时间：</label><span>${new Date(user.createTime * 1000).toLocaleString()}</span></div>
            <div><label>更新时间：</label><span>${new Date(user.updateTime * 1000).toLocaleString()}</span></div>
        `;
    }

    // 注销按钮点击事件
    document.getElementById('logoutButton').addEventListener('click', function () {
        // 清除用户登录信息，跳转到登录页面
        window.location.href = '../login.html';
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

// 各按钮点击事件
document.getElementById('doAttendance').addEventListener('click', function () {
    axios.post(`http://localhost:3000/user/emp/attendance/${userId}`)
        .then(function (response) {
            if (response.data.code == "0") {
                showModal('考勤成功');
            } else {
                showModal('考勤失败：' + response.data.message);
            }
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            showModal('请求失败，请稍后再试。');
        });
});

document.getElementById('getAttendance').addEventListener('click', function () {
    axios.get(`http://localhost:3000/user/emp/attendance/${userId}`)
        .then(function (response) {
            if (response.data.code == "0") {
                var attendance = response.data.data;
                console.log(response.data)
                var content = '<h3>考勤记录：</h3><ul>';

                if (attendance != null) {
                    attendance.forEach(function (record) {
                        const date = new Date(record.date * 1000); // 转换为毫秒
                        const formattedDate = date.toLocaleString();
                        if (record.status == "1") {
                            content += `<li>${formattedDate}   &nbsp&nbsp&nbsp&nbsp  已签到</li>`;
                        }else{
                            content += `<li>${formattedDate}   &nbsp&nbsp&nbsp&nbsp  未签</li>`
                        }
                    });
                }
                content += '</ul>';

                showModal(content);
            } else {
                showModal('无法获取考勤记录：' + response.data.message);
            }
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            showModal('请求失败，请稍后再试。');
        });
});

document.getElementById('getReward').addEventListener('click', function () {
    axios.get(`http://localhost:3000/user/emp/reward/${userId}`)
        .then(function (response) {
            if (response.data.code == "0") {
                var reward = response.data.data;
                var content = `<h3>奖罚记录：</h3><ul>`;

                if (reward != null) {
                    reward.forEach(function (record) {
                        content += `<li>id ${record.rpId}:  type ${record.type}: description ${record.description} date ${record.date}</li>`
                        content += '</ul>';
                    })
                }

                showModal(content);
            } else {
                showModal('无法获取奖罚记录：' + response.data.message);
            }
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            showModal('请求失败，请稍后再试。');
        });
});

document.getElementById('getTraining').addEventListener('click', function () {
    axios.get(`http://localhost:3000/user/emp/training/${userId}`)
        .then(function (response) {
            if (response.data.code == "0") {
                var training = response.data.data;
                var content = `<h3>培训记录：</h3><ul>`;

                if (training != null) {
                    training.forEach(function (record) {
                        content += `<li>id ${record.trainingId}:  name ${record.trainingName}: date ${record.date} result ${record.result}</li>`
                        content += '</ul>';
                    })
                }

                showModal(content);
            } else {
                showModal('无法获取培训记录：' + response.data.message);
            }
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            showModal('请求失败，请稍后再试。');
        });
});

document.getElementById('getDepartment').addEventListener('click', function () {
    axios.get(`http://localhost:3000/user/emp/department/${userId}`)
        .then(function (response) {
            if (response.data.code == "0") {
                var department = response.data.data;
                var content = "";
                if (department != null) {
                    content += `<div>部门信息：${department.info}</div>`;
                    content += `<div>部门名称：${department.departmentName}</div>`
                    content += `<div>部门简述：${department.departmentDescription}</div>`
                    content += `<div>部门人数：${department.emps}</div>`
                } else {
                    content += `<div>部门信息暂时为空</div>`
                }
                showModal(content);
            } else {
                showModal('无法获取部门信息：' + response.data.message);
            }
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            showModal('请求失败，请稍后再试。');
        });
});

document.getElementById('getSalary').addEventListener('click', function () {
    axios.get(`http://localhost:3000/user/emp/salary/${userId}`)
        .then(function (response) {
            if (response.data.code == "0") {
                var content = `<h3>薪水记录：</h3><ul>`;
                var salary = response.data.data;

                if (salary != null) {
                    salary.forEach(function (record) {
                        content += `<li>id ${record.salaryId}:  Basic ${record.basicSalary}: bonus ${record.bonus} deductions ${record.deductions} totalSalary ${record.totalSalary} date ${record.salaryDate}</li>`
                        content += '</ul>';
                    })
                }

                showModal(content);
            } else {
                showModal('无法获取薪水信息：' + response.data.message);
            }
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            showModal('请求失败，请稍后再试。');
        });
});

document.getElementById("showMeeting").addEventListener('click',function(event){
    window.location.href = '../meeting/empevent.html'
})