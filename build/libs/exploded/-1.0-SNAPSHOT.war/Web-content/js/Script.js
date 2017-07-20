$(document).ready(function () {
    $("div.append").css("display","inline");
    $("input.search").after($("div.append"));

    $("i.fa-comment").attr ("data-toggle","modal");
    $("i.fa-comment").attr ("data-target","#topicModal");
    $("i.fa-envelope").attr ("data-toggle","modal");
    $("i.fa-envelope").attr ("data-target","#envelopeModal");
    $("span.glyphicon-link").attr ("data-toggle","modal");
    $("span.glyphicon-link").attr ("data-target","#linkModal");
    $("i.fa-file-o").attr ("data-toggle","modal");
    $("i.fa-file-o").attr ("data-target","#fileModal");



});
