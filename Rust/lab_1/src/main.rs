fn protected_read(variable_name: &str) -> i32 {
    use text_io::try_read;
    loop {
        print!("Enter {}: ", variable_name);
        let read_result: Result<i32, _> = try_read!();
        match read_result {
            Ok(read_integer) => return read_integer,
            Err(_e) => println!("{} must be an integer!", variable_name.to_uppercase()),
        }
    }
}

fn main() {
    let n: i32 = protected_read("n");
    let m: i32 = protected_read("m");
    let a: i32 = protected_read("a");
    let b: i32 = protected_read("b");

    let s: f32 = ((b + m) as f32 / 2f32) * ((m - b + 1) * (n - a + 1)) as f32;

    println!("S = {}", s);
}