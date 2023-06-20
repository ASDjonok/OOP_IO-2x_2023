// #[allow(dead_code)]
fn capitalise(s: &str) -> String {
    let mut c = s.chars();
    match c.next() {
        None => String::new(),
        Some(f) => f.to_uppercase().collect::<String>() + c.as_str(),
    }
}

fn read_row() -> Vec<i16> {
    loop {
        print!("Row (separated by spaces): ");
        let raw_row: String = text_io::read!("{}\n");
        let trimmed_row: &str = raw_row.trim();
        match trimmed_row.split(" ").all(|value| {
            value.chars().all(|char| char.is_numeric())
                && value.parse::<i32>().unwrap() <= i16::MAX as i32
                && value.parse::<i32>().unwrap() >= i16::MIN as i32
        }) {
            true => {
                return trimmed_row
                    .split(" ")
                    .map(|value| value.parse::<i16>().unwrap())
                    .collect::<Vec<i16>>()
            }
            false => println!("[Error] The row must consist of short integers, try again."),
        }
    }
}

fn generate_row(row_index: u16, length: u16) -> Vec<i16> {
    return (0..length)
        .map(|element_index| (element_index as i16 + 1) * (row_index as i16 + 1))
        .collect();
}

fn read_matrix() -> Vec<Vec<i16>> {
    let rows: u16 = protected_u16_read("the number of rows");
    loop {
        print!("Generate matrix or input manually [g/i]: ");
        let option: String = text_io::read!();
        match option.to_lowercase().as_str() {
            "g" => {
                let columns: u16 = protected_u16_read("the number of columns");
                return (0..rows).map(|i| generate_row(i, columns)).collect();
            }
            "i" => return (0..rows).map(|_| read_row()).collect(),
            _ => println!("[Error] Not an option, try again."),
        }
    }
}

fn protected_u16_read(variable_name: &str) -> u16 {
    use text_io::try_read;
    loop {
        print!("Enter {}: ", variable_name);
        let read_result: Result<u16, _> = try_read!();
        match read_result {
            Ok(read_integer) => return read_integer,
            Err(_e) => println!(
                "{} must be a short integer, try again.",
                capitalise(variable_name)
            ),
        }
    }
}

fn multiply_matrix_by_number(matrix: &Vec<Vec<i16>>, multiplier: u16) -> Vec<Vec<i16>> {
    return matrix
        .iter()
        .map(|row| {
            row.iter()
                .map(|element| element * multiplier as i16)
                .collect()
        })
        .collect();
}

fn average_of_row(row: &Vec<i16>) -> f32 {
    return row.iter().sum::<i16>() as f32 / row.len() as f32;
}

fn format_matrix(matrix: &Vec<Vec<i16>>) -> String {
    let max_element_width = matrix
        .iter()
        .map(|row| row.iter().max().unwrap())
        .max()
        .unwrap()
        .to_string()
        .len();
    let min_element_width = matrix
        .iter()
        .map(|row| row.iter().min().unwrap())
        .min()
        .unwrap()
        .to_string()
        .len();

    let max_width = max_element_width.max(min_element_width);

    let mut formatted_matrix: String = matrix
        .iter()
        .map(|row| {
            row.iter()
                .map(|element| format!("| {:max_width$} ", element))
                .collect::<Vec<String>>()
                .join("")
        })
        .collect::<Vec<String>>()
        .join("|\n");
    formatted_matrix.push('|');
    return formatted_matrix;
}

fn main() {
    let full_vec_test: Vec<Vec<i16>> = read_matrix();
    println!("\nMatrix B:\n{}\n", format_matrix(&full_vec_test));

    let mult_full_vec_test: Vec<Vec<i16>> =
        multiply_matrix_by_number(&full_vec_test, protected_u16_read("matrix multiplier"));
    println!("Matrix a×B:\n{}\n", format_matrix(&mult_full_vec_test));

    let row_averages: Vec<f32> = mult_full_vec_test
        .iter()
        .map(|row| average_of_row(row))
        .collect();
    println!("Averages for each row in a×B:");
    row_averages
        .iter()
        .for_each(|element| println!("{}", element))
}
