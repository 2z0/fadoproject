$.ajax({
    url: 'chartdata',
    success: function (result) {
        let company = JSON.parse(result).cp;
        let volume = JSON.parse(result).vm;

        Highcharts.chart('example', {
            colors: ["#e85a71", "#4ea1d3", "#454552", "#d8e9ef"
            ],
            chart: {
                type: 'column'
            },
            title: {
                text: ''
            },
            xAxis: {
                categories: company
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
                data: volume
            }]
        });
    }

})



