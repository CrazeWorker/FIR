let chart = null;

function initChart(canvas, width, height, F2) {
  const data = [
    { name: '抬头率', 日期: '周一', 比率: 18.9 },
    { name: '抬头率', 日期: '周二', 比率: 28.8 },
    { name: '抬头率', 日期: '周三', 比率: 39.3 },
    { name: '抬头率', 日期: '周四', 比率: 81.4 },
    { name: '抬头率', 日期: '周五', 比率: 47 },
    { name: '考勤', 日期: '周一', 比率: 20.3 },
    { name: '考勤', 日期: '周二', 比率: 24 },
    { name: '考勤', 日期: '周三', 比率: 35.6 },
    { name: '考勤', 日期: '周四', 比率: 12.4 },
    { name: '考勤', 日期: '周五', 比率: 23.2 },
    { name: '分数', 日期: '周一', 比率: 34.5 },
    { name: '分数', 日期: '周二', 比率: 99.7 },
    { name: '分数', 日期: '周三', 比率: 52.6 },
    { name: '分数', 日期: '周四', 比率: 35.5 },
    { name: '分数', 日期: '周五', 比率: 37.4 },
  ];
  chart = new F2.Chart({
    el: canvas,
    width,
    height
  });
  chart.source(data);
  chart.tooltip({
    custom: true, // 自定义 tooltip 内容框
    onChange(obj) {
      const legend = chart.get('legendController').legends.top[0];
      const tooltipItems = obj.items;
      const legendItems = legend.items;
      const map = {};
      legendItems.map(item => {
        map[item.name] = Object.assign({}, item);
      });
      tooltipItems.map(item => {
        const { name, value } = item;
        if (map[name]) {
          map[name].value = value;
        }
      });
      legend.setItems(Object.values(map));
    },
    onHide() {
      const legend = chart.get('legendController').legends.top[0];
      legend.setItems(chart.getLegendItems().country);
    }
  });

  chart.interval().position('日期*比率')
    .color('name', ['l(90) 0:#fe769a 1:#feb996', 'l(90) 0:#b194fa 1:#4bcbeb','l(90) 0:#1fcfb5 1:#2cd1b9'])
    .adjust({
      type: 'dodge',
      marginRatio: 0.1 // 设置分组间柱子的间距
    });
  chart.render();
  return chart;
}

Page({
  onShareAppMessage: function (res) {
    return {
      title: 'F2 微信小程序图表组件，你值得拥有~',
      path: '/pages/index/index',
      success: function () { },
      fail: function () { }
    }
  },
  data: {
    opts: {
      onInit: initChart
    }
  },

  onReady() {
  }
});
