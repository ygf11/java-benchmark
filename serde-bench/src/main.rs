use serde::Serialize;

#[derive(Serialize)]
struct Point {
    x: i32,
    y: i32,
}

fn main() {
    let _point = Point { x: 1, y: 10 };
    let serialize = serde_json::to_string(&_point).unwrap();    
    println!("serialize:{}", serialize);
}
