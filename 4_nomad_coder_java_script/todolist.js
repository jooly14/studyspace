const todoForm = document.querySelector(".js-form-todolist"),
    todoInput = todoForm.querySelector("input"),
   todoList =  document.querySelector(".js-list-todolist");

const TODO_LS = "todos";

let TODOS =[];

function saveTodos(){
    localStorage.setItem(TODO_LS,JSON.stringify(TODOS));
}

function loadTodos(){
    const loadedTodos = localStorage.getItem("todos");
    if(loadedTodos !== null){
        const parsedTodos = JSON.parse(loadedTodos);
        parsedTodos.forEach(function(todo){
           paintTodo(todo.text);
        });
    }
    
}



function deleteTodos(event){
    event.preventDefault();
    const btn = event.target;
    const li = btn.parentNode;
    todoList.removeChild(li);
    const cleanTodos = TODOS.filter(function(todo){
      return todo.id !== parseInt(li.id);
    });
      TODOS = cleanTodos;
        saveTodos();
}
function paintTodo(text){
    const li = document.createElement("li");
    const delBtn = document.createElement("button");
    const span = document.createElement("span");
    const newId = TODOS.length+1;
    
    delBtn.innerText = "X";
    span.innerText = text;
    li.appendChild(delBtn);
    li.appendChild(span);
    li.id = newId;
    todoList.appendChild(li);
    
    const todoObj = {
    text: text,
    id : newId
    };

    TODOS.push(todoObj);
    saveTodos();

    delBtn.addEventListener("click",deleteTodos);

}
function handleSubmit(event){
    event.preventDefault();
    const currentValue = todoInput.value;
    paintTodo(currentValue);
    todoInput.value ="";
}

function init(){
    loadTodos();
    todoForm.addEventListener("submit",handleSubmit);
}
init();
