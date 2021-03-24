function sayHello(name, chicken){
    console.log(`Hello ${name}. You ate ${chicken}`);
    return (`Hello ${name}. You ate ${chicken}`);
  }
  
  const name= "nico";
  
  const greetingNico = sayHello(name,"Tomato");
  console.log(greetingNico);
  
  const calculator = {
    plus : function(a,b){
      return a+b;
    } ,
    minus:function(a,b){
      return a-b;
    },
    multiply: function(a,b){
      return a*b;
    },
    divide: function(a,b){
      return a/b;
    },
    power:function(a){
      return a*a;
    }
  }
  console.log(calculator.plus(1,2));
  console.log(calculator.minus(1,2));
  console.log(calculator.multiply(1,2));
  console.log(calculator.divide(1,2));
  console.log(calculator.power(2));