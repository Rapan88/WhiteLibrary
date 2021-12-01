
let res = document.querySelector('.wordPanel')


document.querySelectorAll('.item').forEach((item) =>
  item.addEventListener('click', ()=>{
      item.parentNode.classList.toggle('accordionItemActive')
  })
)

document.querySelectorAll('.addWordPanel').forEach((item) =>
  item.addEventListener('click',()=>{
    event.preventDefault()
    res.classList.toggle('hide')


  })
)

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown menu if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}

