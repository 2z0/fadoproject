Highcharts.chart('myStackedBarChart', {
    colors: ["#e85a71","#4ea1d3","#454552","#d8e9ef"
    ],
    chart: {
        type: 'column'
    },
    title: {
        text: ''
    },
    xAxis: {
        categories: ['5/13', '5/14', '5/15', '5/16', '5/17']
    },
    yAxis: {
        min: 0,
        title: {
            text: 'won'
        },
        stackLabels: {
            enabled: true,
            style: {
                fontWeight: 'bold',
                color: ( // theme
                    Highcharts.defaultOptions.title.style &&
                    Highcharts.defaultOptions.title.style.color
                ) || 'gray'
            }
        }
    },
    legend: {
        align: 'right',
        x: -30,
        verticalAlign: 'top',
        y: 25,
        floating: true,
        backgroundColor:
            Highcharts.defaultOptions.legend.backgroundColor || 'white',
        borderColor: '#CCC',
        borderWidth: 1,
        shadow: false
    },
    tooltip: {
        headerFormat: '<b>{point.x}</b><br/>',
        pointFormat: '{series.name}: {point.y}<br/>Total: {point.stackTotal}'
    },
    plotOptions: {
        column: {
            stacking: 'normal',
            dataLabels: {
                enabled: false
            }
        }
    },
    series: [{
        name: '외국인',
        data: [50000, 30000, 40000, 70000, 21125]
    }, {
        name: '기관',
        data: [24425, 24242, 35858, 27986, 14144]
    }, {
        name: '개인',
        data: [3457, 4758, 4388, 21111, 9888]
    }]
});