// pages/charts/log/index.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    beginDate: '',
    endDate: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  // 开始日期时间选择器
  bindBeginDateChange: function (e) {
    this.setData({
      beginDate: e.detail.value
    })
  },
  // 截至日期时间选择器
  bindEndDateChange: function (e) {
    this.setData({
      endDate: e.detail.value
    })
  },
  getLogByDate: function (e) {
    console.log('开始日期：',e.detail.value,' 截至日期：');
  }
})