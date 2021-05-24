Highcharts.chart('myCirclePacking', {
    colors: ["#e85a71","#4ea1d3","#454552","#d8e9ef"
    ],
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
            cursor:'pointer',
            point:{
                events:{
                    click: function (e){
                        //location.href="charts.html";
                        if(e.point.name!=null){
                            location.href="charts.html";
                        }else if(e.point.series.name!=null){
                            location.href="group.html";
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
    series: [{
        name: 'SI',
        data: [{
            name: '(주)다우기술',
            value: 767.1
        }, {
            name: '(주)엘지씨엔에스',
            value: 20.7
        },
        {
            name: "(주)포스코아이씨티",
            value: 97.2
        },
        {
            name: "롯데정보통신(주)",
            value: 111.7
        },
        {
            name: "삼성에스디에스(주)",
            value: 1158.1
        },
        {
            name: "에이치솔루션(주)",
            value: 241.6
        },
        {
            name: "우리에프아이에스(주)",
            value: 249.1
        }]
    }, {
        name: '도시가스',
        data: [{
            name: "한국가스공사",
            value: 409.4
        },
        {
            name: "(주)삼천리",
            value: 34.1
        },
        {
            name: "(주)예스코",
            value: 7.1
        },
        {
            name: "(주)예스코홀딩스",
            value: 7.1
        },
        {
            name: "대성에너지(주)",
            value: 7.1
        },
        {
            name: "(주)대륜이엔에스",
            value: 7.1
        }]
    }, {
        name: '디스플레이패널',
        data: [{
            name: "엘지디스플레이(주)",
            value: 7.6
        }]
    }, {
        name: '호텔',
        data: [{
            name: "(주)호텔롯데",
            value: 27.2
        },{
            name: "(주)조선호텔앤리조트",
            value: 77.2
        },{
            name: "(주)호텔신라",
            value: 17.2
        },{
            name: "파르나스호텔(주)",
            value: 67.2
        }]
    }, {
        name: '방송서비스',
        data: [{
            name: "(주)씨씨에스충북방송",
            value: 6.5
        },
        {
            name: "(주)씨제이이엔엠",
            value: 6.5
        },
        {
            name: "(주)에스비에스",
            value: 687.4
        },
        {
            name: "(주)현대퓨처넷",
            value: 87.4
        },
        {
            name: "스튜디오드래곤(주)",
            value: 7.9
        },
        {
            name: "제이티비씨(주)",
            value: 449.1
        },
        {
            name: "제이티비씨스튜디오(주)",
            value: 14.7
        },
        {
            name: "제이티비씨스포츠(주)",
            value: 16.6
        },
        {
            name: "제이티비씨플러스(주)",
            value: 20.5
        }]
    }, {
        name: '반도체',
        data: [{
            name: "에스케이하이닉스(주)",
            value: 777.2
        }]
    }, {
        name: '섬유',
        data: [{
            name: "(주)휴비스",
            value: 77.2
        },
        {
            name: "코오롱인더스트리(주)",
            value: 777.2
        },
        {
            name: "효성첨단소재(주)",
            value: 177.2
        },
        {
            name: "효성티앤씨(주)",
            value: 77.2
        }]
    }, {
        name: '석유화학',
        data: [{
            name: "(주)엘지화학",
            value: 1777.2
        },{
            name: "(주)한솔케미칼",
            value: 77.2
        },{
            name: "국도화학(주)",
            value: 77.2
        },{
            name: "롯데케미칼(주)",
            value: 1177.2
        },{
            name: "에스케이어드밴스드(주)",
            value: 77.2
        },{
            name: "에이치디씨현대이피(주)",
            value: 77.2
        },{
            name: "한화솔루션(주)",
            value: 577.2
        },{
            name: "율촌화학(주)",
            value: 77.2
        },{
            name: "한화종합화학(주)",
            value: 77.2
        },{
            name: "휴켐스(주)",
            value: 77.2
        },{
            name: "효성화학(주)",
            value: 177.2
        },{
            name: "한화토탈(주)",
            value: 377.2
        },{
            name: "오씨아이(주)",
            value: 77.2
        },{
            name: "에스케이피아이씨글로벌(주)",
            value: 77.2
        }]
    }, {
        name: '항공운송',
        data: [{
            name: "(주)대한항공",
            value: 777.2
        },{
            name: "(주)아시아나항공",
            value: 677.2
        }]
    }, {
        name: '비철금속',
        data: [{
            name: "(주)디비메탈",
            value: 17.2
        },{
            name: "(주)알루코",
            value: 77.2
        },{
            name: "(주)풍산",
            value: 177.2
        },{
            name: "롯데알미늄(주)",
            value: 777.2
        }]
    }]
});
