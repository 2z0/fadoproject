function drawSpiderWeb4Potentiality(name, dataOri){
    var data = []

    //총자산증가율
    if(dataOri[0]>25)
        data[0] = 5;
    else if(dataOri[0]>20)
        data[0] = 4;
    else if(dataOri[0]>25)
        data[0] = 3;
    else if(dataOri[0]>10)
        data[0] = 2;
    else
        data[0] = 1;

    //총자산증가율
    if(dataOri[1]>25)
        data[1] = 5;
    else if(dataOri[1]>20)
        data[1] = 4;
    else if(dataOri[1]>25)
        data[1] = 3;
    else if(dataOri[1]>10)
        data[1] = 2;
    else
        data[1] = 1;

    //총자산증가율
    if(dataOri[2]>25)
        data[2] = 5;
    else if(dataOri[2]>20)
        data[2] = 4;
    else if(dataOri[2]>25)
        data[2] = 3;
    else if(dataOri[2]>10)
        data[2] = 2;
    else
        data[2] = 1;

    //총자산증가율
    if(dataOri[3]>25)
        data[3] = 5;
    else if(dataOri[3]>20)
        data[3] = 4;
    else if(dataOri[3]>25)
        data[3] = 3;
    else if(dataOri[3]>10)
        data[3] = 2;
    else
        data[3] = 1;




    Highcharts.chart('MySpiderWeb4Potentiality', {
        chart: {
            polar: true,
            type: 'line'
        },

        accessibility: {
            description: 'A spiderweb chart compares the allocated budget against actual spending within an organization. The spider chart has six spokes. Each spoke represents one of the 6 departments within the organization: sales, marketing, development, customer support, information technology and administration. The chart is interactive, and each data point is displayed upon hovering. The chart clearly shows that 4 of the 6 departments have overspent their budget with Marketing responsible for the greatest overspend of $20,000. The allocated budget and actual spending data points for each department are as follows: Sales. Budget equals $43,000; spending equals $50,000. Marketing. Budget equals $19,000; spending equals $39,000. Development. Budget equals $60,000; spending equals $42,000. Customer support. Budget equals $35,000; spending equals $31,000. Information technology. Budget equals $17,000; spending equals $26,000. Administration. Budget equals $10,000; spending equals $14,000.'
        },

        title: {
            text: '',
            x: -80
        },

        pane: {
            size: '80%'
        },

        xAxis: {
            categories: ['총자산증가율', '유동자산증가율', '자기자본증가율', '매출액증가율'],
            tickmarkPlacement: 'on',
            lineWidth: 0
        },

        yAxis: {
            gridLineInterpolation: 'polygon',
            lineWidth: 0,
            min: 0
        },

        tooltip: {
            shared: true,
            pointFormat: '<span style="color:{series.color}">{series.name}: <b>{point.y:,.0f}</b><br/>'
        },

        legend: {
            enabled: false
        },

        series: [{
            name: name,
            data: data,
            pointPlacement: 'on'
        }],

        responsive: {
            rules: [{
                condition: {
                    maxWidth: 500
                },
                chartOptions: {
                    legend: {
                        align: 'center',
                        verticalAlign: 'bottom',
                        layout: 'horizontal'
                    },
                    pane: {
                        size: '70%'
                    }
                }
            }]
        }
    });

}