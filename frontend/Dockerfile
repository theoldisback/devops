# Step 1: Build the Angular application
FROM node:18 AS build

WORKDIR /app
COPY . .

RUN npm install
RUN npm run build -- --configuration production

# Step 2: Serve the Angular application
FROM nginx:alpine

# Copy the build files from the build stage to the Nginx server
COPY --from=build /app/dist/angular-17-crud /usr/share/nginx/html

# Expose the port where Nginx will serve the app
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
