
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
