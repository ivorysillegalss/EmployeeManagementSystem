document.addEventListener('DOMContentLoaded', function() {
    // 获取按钮元素
    const viewMeetingBtn = document.getElementById('viewMeetingBtn');
    const viewProcurementBtn = document.getElementById('viewProcurementBtn');
    const viewHRChangesBtn = document.getElementById('viewHRChangesBtn');
    const viewTakingDayOff = document.getElementById('viewTakingDayOff');

    // 绑定点击事件
    viewMeetingBtn.addEventListener('click', function() {
        // 跳转到查看会议页面
        window.location.href = './meeting/bossevent.html'; // 页面路径可以根据你的实际情况修改
    });

    viewProcurementBtn.addEventListener('click', function() {
        // 跳转到查看采购页面
        window.location.href = './purchase/columns.html'; // 页面路径可以根据你的实际情况修改
    });

    viewHRChangesBtn.addEventListener('click', function() {
        // 跳转到查看人事变动页面
        window.location.href = './positionchange/positionchange.html'; // 页面路径可以根据你的实际情况修改
    });

    viewTakingDayOff.addEventListener('click',function (){
        window.location.href = './vacation/bossAuditvacation.html'
    })


});
