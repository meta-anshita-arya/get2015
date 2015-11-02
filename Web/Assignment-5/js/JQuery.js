 $(window).load(function() {
        $('#slider').impulseslider({
            height: 300,
            width: 400,
            depth: 275,
            perspective: 2000,
            pauseTime: 1500,
            transitionDuration: 1000,
            transitionEffect: "ease-in-out",
            autostart: true,
            rightSelector: ".right",
            leftSelector: ".left",
            pauseSelector: ".pause",
            directionRight: true,
            containerSelector: "#slider-container",
            spinnerSelector: "#slider",
            images: ["img/18410882_s.jpg","img/19022602_s.jpg","img/20151268_s.jpg","img/20151272_s.jpg","img/20461992_s.jpg"],
            imageDivClasses: ["face"]
        });
    });