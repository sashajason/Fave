(
    function ($) {
        "use strict";

        // manual favorite-carousel controls
        $('.nextFavorites').click(function () { $('.favorite-carousel').carousel('next'); return false; });
        $('.prevFavorites').click(function () { $('.favorite-carousel').carousel('prev'); return false; });

        // manual pastEvents-carousel controls
        $('.nextEvent').click(function () { $('.pastEvents-carousel').carousel('next'); return false; });
        $('.prevEvent').click(function () { $('.pastEvents-carousel').carousel('prev'); return false; });
    }

)(jQuery);