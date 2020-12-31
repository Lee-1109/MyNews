function updateVerify(mid){
    let count =0;
    let a_id = document.getElementById(mid);
    if(count%2){
        a_id.innerHTML ="<a href='#' onclick='updateVerify(mid)'>confirm</a>";
        count++;
    }else {
        a_id.innerHTML ="<a href='#' onclick='updateVerify(mid)'>update</a>";
        count++;
    }
    let grant_td = document.getElementById("td"+mid);//获取对应的点击标签
    grant_td.innerHTML="<select>" +
        "<option>admin</option>" +
        "<option>staff</option>" +
        "</select>";

    return false;
}

function recover(id){
    alert("sajnfnaafn"+id);
}