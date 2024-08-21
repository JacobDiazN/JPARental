document.addEventListener('DOMContentLoaded', function() {
    setInterval(function(){
        const nextButton = document.querySelector('#carouselExampleFade .carousel-control-next');
        if (nextButton) {
            nextButton.click();
        }
    }, 6500);
});

