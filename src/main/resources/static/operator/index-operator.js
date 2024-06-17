window.onload = function () {
    getOperationLog();
    // 页面加载时调用
};

function getOperationLog() {
    axios.get('http://localhost:3000/operator/init')
        .then(function (response) {

            var logList = '';

            // 响应成功
            if (response.data.code == "0") {
                let value = response.data.data;
                if (value.length > 0) {
                    value.forEach(function (log) {
                        var listItem = document.createElement('li');
                        listItem.textContent = '操作ID: ${log.id}, 操作内容: ${log.content}';
                        logList.appendChild(listItem);
                    });
                } else {
                    console.log("操作日志为空")
                    logList = '操作日志为空';
                }
            } else {
                console.log("请求错误");
            }
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            document.getElementById('logResult').innerText = '请求失败，请稍后再试。';
        })
}


function getOperationLogById() {
    var operatorId = document.getElementById('operatorId').value;
    axios.get(`http://localhost:3000/operator/init/${operatorId}`)
        .then(function (response) {

            var logList = document.getElementById('logList');

            // 响应成功
            if (response.data.code == "0") {

                console.log(response.data)

                let value = response.data.data;
                if (value.length > 0) {
                    value.forEach(function (log) {
                        var listItem = document.createElement('li');
                        listItem.textContent = `操作ID: ${log.logId}, 操作内容: ${log.action}`;
                        logList.appendChild(listItem);
                    });
                } else {
                    console.log("操作日志为空")
                    logList = '操作日志为空';
                }
            } else {
                console.log("请求错误");
            }
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            document.getElementById('logResult').innerText = '请求失败，请稍后再试。';
        })
}


function modifyPermission() {
    var operatorId = document.getElementById('modifyOperatorId').value;
    var userId = document.getElementById('modifyUserId').value;
    var newRole = document.getElementById('newRole').value;
    var operatorDTO = {
        newRole: newRole
    };

    axios.post(`http://localhost:3000/operator/modify/${operatorId}/user/${userId}`, operatorDTO)
        .then(function (response) {
            document.getElementById('modifyResult').innerText = response.data.message;
        })
        .catch(function (error) {
            console.error('请求失败:', error);
            document.getElementById('modifyResult').innerText = '请求失败，请稍后再试。';
        });
}





// 插入新操作员
// TODO 
function insertNewOperator() {
    var operatorId = document.getElementById('insertOperatorId').value;
    var operator = document.getElementById('operator').value;
    var user = document.getElementById('user').value;
    var operatorDTO = {
        operator: operator,
        user: user
    };
    
    axios.post(`http://localhost:3000/operator/insert/${operatorId}`, operatorDTO)
        .then(function(response) {
            document.getElementById('insertResult').innerText = response.data.message;
        })
        .catch(function(error) {
            console.error('请求失败:', error);
            document.getElementById('insertResult').innerText = '请求失败，请稍后再试。';
        });
}





document.getElementById("insert").addEventListener('click',function(event){
    window.location.href = './insert.html'
})


document.getElementById("modify").addEventListener('click',function(event){
    window.location.href = './modify/modify.html'
})


document.getElementById("exit").addEventListener('click',function(event){
    window.location.href = '../login.html'
})