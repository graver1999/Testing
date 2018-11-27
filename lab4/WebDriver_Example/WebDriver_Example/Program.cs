using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WebDriver_Example
{
    class Program
    {
        static void Main(string[] args)
        {
            IWebDriver driver = new ChromeDriver();
            driver.Url = "https://airalgerie.dz/planifier-votre-voyage/nos-destinations/";

            driver.Manage().Window.Maximize();
            driver.Manage().Timeouts();

            
            driver.FindElement(By.ClassName("-new-booking")).Click();
            driver.FindElement(By.ClassName("js-city-departure")).SendKeys("Paris (CDG)");
            driver.FindElement(By.ClassName("js-city-arrival")).SendKeys("Beyrouth (BEY)");
            driver.FindElement(By.ClassName("js-datepicker-departure")).Click();

            driver.FindElement(By.XPath("//*[@ui-state-default ui-state-active='28']")).Click();
            driver.FindElement(By.ClassName("js-datepicker-arrival")).Click();
            driver.FindElement(By.XPath("//*[@ui-state-default ui-state-active='29']")).Click();
            driver.FindElement(By.ClassName("simple-btn js-submit-booking")).Click();

        }
    }
}
