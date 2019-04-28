Page({
  data: {
    currentData : 0,
    charts: [
      { name: 'dodge', value: '表现统计' },
      { name: 'ring', value: '分数占比' },
      { name: 'log', value: '考勤日志' }
    ],
    imgSrcs: [
      {"src":"../../img/单人女2.jpg"},
      {"src":"../../img/单人女3.jpg"}
    ],
    conditions: [
      { date: 'today',value: '今日',compared: '昨日'},
      { date: 'week', value: '本周', compared: '上周' },
      { date: 'month',value: '本月', compared: '上月' }
    ],
    items: [
      { name: 'platform', value: '课堂表现分数' },
      { name: 'liftup', value: '抬头率' },
      { name: 'attendance', value: '考勤率' }
    ],
    grade: 0.0,
    compare:30.0
  },
  gotoPage: function (e) {
    var page = e.currentTarget.dataset.page;
    wx.navigateTo({
      url: '../charts/' + page + '/index'
    });
  },
  // 打开页面请求数据
  onLoad: function () {
    // var that = this;
    // wx.request({
    //   url: 'http://localhost:8080/test/showData',
    //   data: {
    //     studntId:'1102'
    //   },
    //   header: {
    //     'content-type': 'application/json'
    //   },
    //   success: function(res){
    //     var getGrade = res.grade;
    //     var getCompared = res.compared;
    //     that.setData ({
    //       grade: res.data.grade,
    //       compare: res.data.compared
    //     })
    //   }
    // })
  },
  //获取当前滑块的index
  bindchange: function (e) {
    const that = this;
    that.setData({
      currentData: e.detail.current
    })
  },
  //点击切换，滑块index赋值
  checkCurrent: function (e) {
    const that = this;

    if (that.data.currentData === e.target.dataset.current) {
      return false;
    } else {
      that.setData({
        currentData: e.target.dataset.current
      })
    }
  }
})