// 当网页向下滑动 20px 出现"返回顶部" 按钮
window.onscroll = function() {
    scrollFunction()
};

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("btnTop").style.display = "block";
    } else {
        document.getElementById("btnTop").style.display = "none";
    }
}

// 点击按钮，返回顶部
function returnTop() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}

// 百度统计
var _hmt = _hmt || [];
(function () {
    var hm = document.createElement("script");
    hm.src = "https://hm.baidu.com/hm.js?d21b80c0023c7330b7031c0122dc5633";
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(hm, s);
})();
