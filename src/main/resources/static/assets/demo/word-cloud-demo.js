var text = '삼성전자가 D램 모듈용으로 PMIC를 생산한 적은 처음이다. DDR4 D램은 PMIC를 외부 기판에 탑재했지만, 새로운 규격인 DDR5 D램부터는 PMIC를 D램 모듈 기판에 직접 탑재한다.PMIC와 D램이 하나의 모듈에 위치하기 때문에 전원을 안정적이고 빠르게 공급할 수 있다.삼성전자는 자체 설계 기술인 [비동기식 2상 전압 강하 제어 회로]를 적용, 전압의 변화를 실시간으로 빠르게 감지하고 출력 전압을 일정하게 유지할 수 있다.또 이 기술로 DDR5 D램의 데이터 읽기, 쓰기 속도를 더욱 안정적으로 지원한다. 전압을 일정하게 유지하기 위해 탑재하던 적층세라믹콘덴서(MLCC) 사용량까지 줄일 수 있어 D램 모듈 설계 편의성이 높아졌다.삼성전자는 기업용 PMIC(S2FPD01, S2FPD02)에 출력 전압을 효율적으로 조정하는 자체 설계 방식인 하이브리드 게이트 드라이버를 적용해 전력효율을 91%까지 향상시켰다.데스크탑, 노트북 PC등 소비자용 DDR5 D램 모듈에 탑재되는 전력관리반도체(S2FPC01)는 저전력 90나노(nm)공정을 적용해 칩 면적을 줄였다.향후 삼성전자는 새로운 DDR5 D램에 맞춘 차세대 PMIC로 관련 시장 진출에 박차를 가할 계획이다. 시장조사업체 옴디아에 따르면 세계 PMIC 시장은 지난해 54억달러(약 6조원)에서 2024년 69억달러로 연평균 6.6% 성장을 기록할 것으로 예상된다.조장호 삼성전자 시스템LSI사업부 상무는 “디스플레이, 솔리드스테이트드라이브(SSD) PMIC에서 쌓은 설계 기술력과 노하우를 데이터센터, 서버와 PC 등에 탑재되는 DDR5 D램 메모리 모듈에도 적용했다”며 “D램용 PMIC 제품군을 지속 강화하며 기술 리더십을 확대할 것”이라고 말했다.';
var lines = text.split(/[,\. ]+/g),
    data = Highcharts.reduce(lines, function (arr, word) {
        var obj = Highcharts.find(arr, function (obj) {
            return obj.name === word;
        });
        if (obj) {
            obj.weight += 1;
        } else {
            obj = {
                name: word,
                weight: 1
            };
            arr.push(obj);
        }
        return arr;
    }, []);

Highcharts.chart('myWordCloud', {
    accessibility: {
        screenReaderSection: {
            beforeChartFormat: '<h5>{chartTitle}</h5>' +
                '<div>{chartSubtitle}</div>' +
                '<div>{chartLongdesc}</div>' +
                '<div>{viewTableButton}</div>'
        }
    },
    series: [{
        type: 'wordcloud',
        data: data,
        name: 'Occurrences'
    }],
    title: {
        text: ''
    }
});