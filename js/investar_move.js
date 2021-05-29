$.ajax({
    url: 'move',
    success: function (result) {
        let fore = JSON.parse(result).fore;
        let agen = JSON.parse(result).agen;
        Highcharts.chart('exam', {
            chart: {
                type: 'column'
            },
            title: {
                text: '외국인&기관 일별 매매동향'
            },
            xAxis: {
                categories: ['05/29']
            },
            credits: {
                enabled: false
            },
            series: [{
                name: '외국인',
                data: fore
            }, {
                name: '기관',
                data: agen
            }]
        });
    }
})