from com.ky.tests.jython import Calculator

class Adder(Calculator):
    def calc(self, x, y):
        return self.m_factor + x + y
    
class Multipler(Calculator):
    def calc(self, x, y):
        return self.m_factor + x * y