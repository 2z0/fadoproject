$.ajax({
    url: 'circlepacking',
    success: function (result) {
        let circlePackingData = JSON.parse(result).circlePacking;
        Highcharts.chart('myCirclePacking', {
            chart: {
                type: 'packedbubble',
                height: '60%',
            },
            title: {
                text: ''
            },
            tooltip: {
                useHTML: true,
                pointFormat: '<b>{point.name}:</b> {point.value}</sub>'
            },
            plotOptions: {
                series: {
                    cursor: 'pointer',
                    point: {
                        events: {
                            click: function (e) {
                                //location.href="charts.html";
                                if (e.point.name != null) {
                                    location.href = "charts.html";
                                } else if (e.point.series.name != null) {
                                    location.href = "group.html";
                                }
                            }
                        }
                    }

                },
                packedbubble: {
                    minSize: '20%',
                    maxSize: '100%',
                    zMin: 0,
                    zMax: 1000,
                    layoutAlgorithm: {
                        gravitationalConstant: 0.05,
                        splitSeries: true,
                        seriesInteraction: false,
                        dragBetweenSeries: true,
                        parentNodeLimit: true
                    },
                    dataLabels: {
                        enabled: true,
                        format: '{point.name}',
                        filter: {
                            property: 'y',
                            operator: '>',
                            value: 250
                        },
                        style: {
                            color: 'black',
                            textOutline: 'none',
                            fontWeight: 'normal'
                        }
                    }
                }
            },
            series: circlePackingData
        });
    }
})