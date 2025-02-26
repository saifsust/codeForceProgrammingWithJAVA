
function myObject(){
    let vals = new Set()
    return {
        add: (value)=>vals.add(value),
        remove: (value)=>vals.delete(value),
        getList: ()=>Array.from(vals)
    }
}

const obj = myObject();
obj.add(2324);
obj.add(3343);
obj.remove(3343);
console.log(obj.getList());
