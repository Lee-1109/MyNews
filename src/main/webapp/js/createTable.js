function createAddAdminTable(){
    let table = document.getElementById("holder");//获取第一个表格
    let tBody=document.createElement("tBody");
    if (table.firstChild) {
        table.removeChild(table.firstChild);
        table.removeChild(table.firstChild);
    }
    //创建表头
        let tr=tBody.insertRow(0);
        tr.setAttribute("class","tableHead")
        let ID=tr.insertCell(0);
        ID.innerText="COUNT";
        let password=tr.insertCell(1);
        password.innerText="PASSWORD";
        let grant=tr.insertCell(2);
        grant.innerText="GRANT";
        let operate=tr.insertCell(3);
        operate.innerText="CONFIRM";
        //生成表身

        let tr1=tBody.insertRow(1);
        tr1.setAttribute("class","tableResult")
        let ID1=tr1.insertCell(0);
        ID1.innerHTML="<input type='text' alt='please input new countID'/>";
        let password1=tr1.insertCell(1);
        password1.innerHTML="<input type='password' alt='please input new password'/>";
        let grant1=tr1.insertCell(2);
        grant1.innerHTML="<select name='grants'>" +
            "<option value='0'>admin</option>" +
            "<option value='1'>staff</option>" +
            "</select>";
        let operate1=tr1.insertCell(3);
        operate1.innerHTML="<a href='#' onclick='return addAdmin()'>add</a>";

    table.appendChild(tBody);
    return false;
}

//添加管理员

function addAdmin(){
    if(confirm("add?")){
        let  password = prompt("please input you password to confirm you identify");
       if(password == "991109"){
           //密码核对成功
           alert("true");
       }else {
           //密码核对失败
           alert("error");
       }
        //使用ajax 加入数据库
       return true;
    }
    return false;
}