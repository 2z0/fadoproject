Highcharts.chart('myBarChart', {
    colors: ["#e85a71","#4ea1d3","#454552","#d8e9ef"
    ],
    chart: {
        type: 'column'
    },
    title: {
        text: ''
    },
    xAxis: {
        categories: [
            '매출액',
            '영업이익',
            '순이익률',
        ],
        crosshair: true
    },
    yAxis: {
        min: 0,
        title: {
            text: 'won'
        }
    },
    tooltip: {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f}won</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    },
    plotOptions: {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        }
    },
    series: [{
        name: '2018',
        data: [49900000, 71500000, 106400000]

    }, {
        name: '2019',
        data: [83600000, 78800000, 98500000]

    }, {
        name: '2020',
        data: [48900000, 38800000, 39300000]

    }]
});