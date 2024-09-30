document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('purchaseForm');

    // 假设 empId 是通过某种方式获得的，比如从登录信息中获取
    const empId = localStorage.getItem('userId');  // 这里可以动态获取实际的用户ID
    localStorage.setItem('userId', empId)
    // 监听表单的提交事件
    form.addEventListener('submit', function (event) {
        event.preventDefault();  // 阻止表单的默认提交行为

        // 获取表单数据
        const entity = document.getElementById('entity').value;
        const quantity = document.getElementById('quantity').value;
        // 构建要发送的数据对象
        const purchaseDTO = {
            entity: entity,
            userId: empId,  // 假设 userId 就是 empId
            nums: quantity
        };

        // 发送POST请求到后端接口
        axios.post(`http://localhost:3000/user/emp/purchase/${empId}`, purchaseDTO)
            .then(function (response) {
                if (response.data.code === "0") {
                    alert('采购申请提交成功');
                    form.reset();  // 成功后重置表单
                } else {
                    alert('采购申请提交失败: ' + response.data.message);
                }
            })
            .catch(function (error) {
                console.error('请求发生错误:', error);
                alert('提交采购申请时发生错误，请稍后再试。');
            });
    });
});

document.getElementById('exit').addEventListener('click', function () {
    // 清除用户登录信息，跳转到登录页面
    window.location.href = '../info.html';
});