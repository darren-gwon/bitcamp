//파일을 분리 했을 떄는 무조건 function안에 주어야한다.

$(function(){
    //총을 클릭하면 0~11사이의 랜덤값을 발생
    //해당 인형을 안보이게 처리
    //메세지창 : n번째 인형을 맞췄네요

    //1번이 이미 사라지고 없는 경우
        //"1번 인형은 이미 처리 되었습니다"
    //12개의 인형이 모두 사라지면
        //"You Win!!"

    //money를 클릭하면 모두 초기화(사라진 인형 재배치, 지우기 등) 후 해당 지폐는 없어지게.
    var n =0;

    $(".gun").click(function(){
        var idx=parseInt(Math.random()*12);

        if ($(".sunban li img").eq(idx).is(":hidden")){
            $("#msg").html((idx+1)+"번 인형은 이미 처리되었습니다.");
        } else {
            n++;
            $("#msg").html((idx+1)+"번째 인형을 맞췄네요!!");
            $(".sunban li img").eq(idx).hide();
        }

        if(n>=12){
            $("#msg").html("Game Over!! You Win!!");
        }
    });


    $(".money img").click(function(){
        //$(this).hide();//자리를 차지하지 않음
        $(this).css("opacity","0");//투명도 0,자리를 차지함
        n=0;
        $(".sunban li img").show();
        $("#msg").html("");
    });
});
