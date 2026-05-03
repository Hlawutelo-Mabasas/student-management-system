document.addEventListener("DOMContentLoaded", function () {
    const deleteForms = document.querySelectorAll("form[data-confirm-delete]");

    deleteForms.forEach(function (form) {
        form.addEventListener("submit", function (event) {
            const studentName = form.getAttribute("data-student-name") || "this student";
            const confirmed = confirm("Are you sure you want to delete " + studentName + "?");

            if (!confirmed) {
                event.preventDefault();
            }
        });
    });
});
