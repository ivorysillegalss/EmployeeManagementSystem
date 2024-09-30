// 假设这是从后端接收到的采购数据
var data = [
    { purchaseId: '001', entity: 'Item A', quantity: 10, hrOpinion: 'Approved', bossOpinion: 'Pending', userId: '101' },
    { purchaseId: '002', entity: 'Item B', quantity: 20, hrOpinion: 'Pending', bossOpinion: 'Approved', userId: '102' },
    { purchaseId: '003', entity: 'Item C', quantity: 15, hrOpinion: 'Rejected', bossOpinion: 'Approved', userId: '103' },
    { purchaseId: '004', entity: 'Item D', quantity: 5, hrOpinion: 'Approved', bossOpinion: 'Rejected', userId: '104' },
    { purchaseId: '005', entity: 'Item E', quantity: 8, hrOpinion: 'Pending', bossOpinion: 'Pending', userId: '105' }
];

// 从后端获取采购数据并合并现有数据
axios.get('http://localhost:3000/boss/purchase')
    .then(function(response) {
        console.log(response.data)
        if (response.data.code === "0") {
            // 从后端获取的数据
            const backendData = response.data.data;

            // 将后端获取的数据与现有数据合并
            data = [...data, ...backendData];

            // 渲染合并后的数据
            renderTable(data);
        } else {
            alert('获取采购信息失败: ' + response.data.message);
        }
    })
    .catch(function(error) {
        console.error('请求发生错误:', error);
        alert('获取采购信息时发生错误，请稍后再试。');
    });


// 将数据动态插入表格
function renderTable(data) {
    var tbody = document.getElementById('table-body');
    tbody.innerHTML = ''; // 清空现有的表格数据
    data.forEach(function(item) {
        var row = `<tr>
            <td>${item.purchaseId}</td>
            <td>${item.entity}</td>
            <td>${item.quantity}</td>
            <td>${item.hrOpinion}</td>
            <td>${item.bossOpinion}</td>
            <td>${item.userId}</td>
            <td>
                <button class="btn btn-success" onclick="approve(${item.purchaseId})">批准</button>
                <button class="btn btn-danger" onclick="reject(${item.purchaseId})">不批准</button>
            </td>
        </tr>`;
        tbody.innerHTML += row;
    });
}

// 批准操作
function approve(purchaseId) {
    if (confirm(`确定要批准用户 ${purchaseId} 的采购申请吗？`)) {
        // 发送批准请求到后端
        axios.post(`http://localhost:3000/hr/purchase/${purchaseId}/1`)
            .then(function(response) {
                if (response.data.code === "0") {
                    alert('采购申请已批准');
                    // 你可以在这里重新获取数据并刷新表格，或者直接更新对应的行
                    renderTable(data); // 假设重新渲染
                } else {
                    alert('操作失败: ' + response.data.message);
                }
            })
            .catch(function(error) {
                console.error('请求失败:', error);
                alert('批准请求时发生错误，请稍后再试。');
            });
    }
}

// 不批准操作
function reject(purchaseId) {
    if (confirm(`确定要不批准用户 ${purchaseId} 的采购申请吗？`)) {
        // 发送拒绝请求到后端
        axios.post(`http://localhost:3000/hr/purchase/${purchaseId}/-1`)
            .then(function(response) {
                if (response.data.code === "0") {
                    alert('采购申请已拒绝');
                    // 你可以在这里重新获取数据并刷新表格，或者直接更新对应的行
                    renderTable(data); // 假设重新渲染
                } else {
                    alert('操作失败: ' + response.data.message);
                }
            })
            .catch(function(error) {
                console.error('请求失败:', error);
                alert('拒绝请求时发生错误，请稍后再试。');
            });
    }
}

// 调用函数渲染表格
renderTable(data);
