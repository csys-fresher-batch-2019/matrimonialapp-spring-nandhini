<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shyloo Matrimony</title>
</head>
<body style="background-image:url('images/123.jpg')">
<div>
		<form action="UserRegisterServlet" method="post">
			<h1>User Registration</h1>
			<table align="left" cellpadding="7">
				<tr>
					<td><h3>Enter User Name:</h3></td>
					<td><input type="text" name="Name" pattern="^[a-zA-Z]+$"
						required  /></td>
					<td><h3>Enter DOB:</h3></td>
					<td><input type="date" name="dob" id="dob" required   /></td>
				</tr>
				<tr>
					<td><h3>Enter Gender:</h3></td>
					<td><input type="radio" name="gender" value="M"> Male<br>
						<input type="radio" name="gender" value="F"> Female<br>
					</td>

					<td><h3>Enter Religion:</h3></td>
					<td><input type="text" name="religion" pattern="^[a-zA-Z]+$"
						required /></td>
				</tr>
				<tr>
					<td><h3>Enter Caste:</h3></td>
					<td><input type="text" name="caste" pattern="^[a-zA-Z]+$"
						required /></td>
					<td><h3>Enter Country:</h3></td>
					<td><input type="text" name="country" pattern="^[a-zA-Z]+$"
						required /></td>
				</tr>

				<tr>
					<td><h3>Enter State:</h3></td>
					<td><input type="text" name="state" pattern="^[a-zA-Z]+$"
						required /></td>

					<td><h3>Enter City:</h3></td>
					<td><input type="text" name="city" pattern="^[a-zA-Z]+$"
						required /></td>
				</tr>

				<tr>
					<td><h3>Enter Mobile.No:</h3></td>
					<td><input type="tel" name="mob" maxlength="10"
						 title="Enter valid mobile Number" required /></td>

					<td><h3>Enter Adhar.No:</h3></td>
					<td><input type="tel" name="aadhar" maxlength="12"
						 title="Enter valid Aadhar Number" required /></td>
				</tr>

				<tr>
					<td><h3>Enter Mail-ID:</h3></td>
					<td><input type="email" name="mail"
						pattern="^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$" required />
					</td>
					<td><h3>Enter Height(ft):</h3></td>
					<td><input type="float" name="height" required /></td>
				</tr>
				<tr>
					<td><h3>Enter Education:</h3></td>
					<td><input type="text" name="education" required  />
					</td>
					<td><h3>
							<label for="marital">Choose your Marital Status:</label>
						</h3></td>
					<td><select id="marital" name="marital">
							<option value="unmarried">Unmarried</option>
							<option value="divorced">Divorced</option>
							<option value="widow">Widow</option>
							<option value="widower">Widower</option>
					</select></td>
				</tr>

				<tr>
					<td><h3>Enter Occupation:</h3></td>
					<td><input type="text" name="occup" required/></td>

					<td><h3>Enter Salary:</h3></td>
					<td><input type="number" name="salary" required /></td>
				</tr>

				<tr>
					<td><h3>
							<label for="plan">Choose a Membership Type:</label>
						</h3></td>
					<td><select id="plan" name="plan">
							<option value="platinum">Platinum</option>
							<option value="gold">Gold</option>
							<option value="silver">Silver</option>
					</select></td>
					<td><h3>Enter Password:</h3></td>
					<td><input type="text" name="pass" required /></td>
				</tr>
				<tr>
					<td><h3>Upload your Picture:</h3></td>
					<td><input type="file" name="pic"></td>
				</tr>
				<tr>
					<td></td>
					<td align="right"><input type="submit" name="register"
						value="submit"></td>
				</tr>
			</table>
			<script>
    var dtToday = new Date();
    var month = dtToday.getMonth()+ 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    var maxDate = year + '-' + month + '-' + day;    
    document.getElementById('dob').setAttribute('max', maxDate);
</script>
		</form>
	</div>
</body>
</html>