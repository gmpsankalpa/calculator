import tkinter as tk

class Application(tk.Frame):
    def __init__(self, master=None):
        super().__init__(master)
        self.master = master
        self.pack()
        self.create_widgets()

    def create_widgets(self):
        self.entry = tk.Entry(self)
        self.entry.pack(side="top")

        self.buttons = []
        for i in range(9):
            self.buttons.append(self.create_button(i+1))

        self.zero_button = self.create_button(0)

        self.add_button = self.create_button("+")
        self.subtract_button = self.create_button("-")
        self.multiply_button = self.create_button("*")
        self.divide_button = self.create_button("/")

        self.clear_button = tk.Button(self)
        self.clear_button["text"] = "C"
        self.clear_button["command"] = self.clear
        self.clear_button.pack(side="left")

        self.equals_button = tk.Button(self)
        self.equals_button["text"] = "="
        self.equals_button["command"] = self.calculate
        self.equals_button.pack(side="left")

    def create_button(self, text):
        return tk.Button(self, text=str(text), command=lambda: self.append_str(text)).pack(side="left")

    def append_str(self, text):
        self.entry.insert(tk.END, str(text))

    def clear(self):
        self.entry.delete(0, tk.END)

    def calculate(self):
        try:
            self.entry.delete(0, tk.END)
            self.entry.insert(tk.END, str(eval(self.entry.get())))
        except Exception as e:
            self.entry.delete(0, tk.END)
            self.entry.insert(tk.END, "Error")

root = tk.Tk()
app = Application(master=root)
app.mainloop()
