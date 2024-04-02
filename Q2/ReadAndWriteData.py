import csv


class ReadAndWriteData:
    def __init__(self, file_path):
        self.file_path = file_path
        self.column_names = []

    def read_csv(self):
        data = []
        with open(self.file_path, mode='r') as file:
            reader = csv.DictReader(file)
            self.column_names = reader.fieldnames
            for row in reader:
                data.append({column: row[column] for column in self.column_names})
        return data


if __name__ == "__main__":
    file_path = "data.csv"
    reader = ReadAndWriteData(file_path)
    data = reader.read_csv()

    for row in data:
        for column_name in reader.column_names:
            print(f"{column_name}: {row[column_name]}")
        print()
