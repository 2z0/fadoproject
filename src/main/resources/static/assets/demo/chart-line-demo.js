function drawLineChart(myPbr, myPer) {
    Highcharts.chart('myLineChart', {
        colors: ["#e85a71", "#4ea1d3", "#454552", "#d8e9ef"
        ],
        title: {
            text: ''
        },

        yAxis: {
            title: {
                text: ''
            }
        },

        xAxis: {
            accessibility: {
                rangeDescription: 'Range: 2010 to 2017'
            }
        },

        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle'
        },

        plotOptions: {
            series: {
                label: {
                    connectorAllowed: false
                },
                pointStart: 2010
            }
        },

        series: [{
            name: 'PER',
            data: myPer
        }, {
            name: 'PBR',
            data: myPbr
        }],

        responsive: {
            rules: [{
                condition: {
                    maxWidth: 500
                },
                chartOptions: {
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom'
                    }
                }
            }]
        }

    });
}