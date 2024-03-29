Highcharts.getJSON('https://demo-live-data.highcharts.com/aapl-ohlc.json', function (data) {

  // create the chart
  Highcharts.stockChart('myCandleChart', {


    rangeSelector: {
      selected: 1
    },
    series: [{
      type: 'candlestick',
      name: 'AAPL Stock Price',
      data: data,
      dataGrouping: {
        units: [
          [
            'week', // unit name
            [1] // allowed multiples
          ], [
            'month',
            [1, 2, 3, 4, 6]
          ]
        ]
      }
    }]
  });
});